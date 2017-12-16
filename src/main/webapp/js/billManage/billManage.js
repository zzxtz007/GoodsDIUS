function bill() {
    let totalPage = 1;
    let currentPage = 1;
    let pageSize = 3;
    let searchKey = {};

    this.init = function () {
        initPro();
        initTable();
    };

    /**
     * 初始化 供应商选择
     */
    function initPro() {
        $.ajax({
            url: "/api/provider/query",
            type: "get"
        }).done(function (response) {
            selectRespHandler(response);
        }).fail(function () {
            alert("未知错误,请稍后再试");
        })
    }

    function gotoPage() {
        $.ajax({
            url: "/api/bill/query",
            type: "get",
            data: searchKey
        }).done(function (response) {
            tableRespHandler(response);
        }).fail(function () {
            alert("未知错误,请稍后再试");
        });
    }

    /**
     * 获得总页数
     * @param response
     */
    function getTotalPage(response) {
        let err = response.status;
        console.log(response.count);
        switch (err) {
            case 0: {
                totalPage=parseInt(response.count)%pageSize==0?parseInt(response.count)/pageSize:parseInt(response.count)/pageSize+1;
                break;
            }
            case 3:
            case 4:
            default: {
                showMsg('未知错误，请稍后再试', 'err');
                break;
            }
        }
    }

    /**
     * 初始化 搜索key
     */
    function initSearch() {
        searchKey={};
        let providerId = $("#proName").val();
        let productName = $("#productName").val();
        if (productName !== ''){
            searchKey["productName"] = productName;
        }
        if (providerId !== '' && providerId !== null){
            searchKey["providerId"] = providerId;
        }
        searchKey["pageNum"] = currentPage;
        searchKey["pageSize"] = pageSize;
        $.ajax({
            url:"/api/bill/count",
            type:"get",
            data:searchKey
        }).done(function (response) {
            getTotalPage(response);
        }).fail(function () {
            alert("未知错误,请稍后再试");
        });
    }

    /**
     * 初始化table
     */
    function initTable() {

        let initS = initSearch();
        let gotoP = gotoPage();

    }

    function initSelect(providers) {
        let select = $("#proName");
        let option = $("<option value=''>--请选择--</option>");
        select.append(option);
        for (let provider of providers) {
            option = $("<option value='" + provider.id + "'>" + provider.proName + "</option>");
            select.append(option);
        }
    }

    /**
     * 处理select请求的响应值
     */
    function selectRespHandler(response) {
        let err = response.status;
        switch (err) {
            case 0: {
                initSelect(response.providers);
                break;
            }
            case 4:
            default: {
                showMsg('未知错误，请稍后再试', 'err');
                break;
            }
        }
    }

    function drawTable(bills) {
        let table = $("#table");
        for (let bill of bills) {
            let tr = $("<tr id= " + bill.id + "></tr>");
            table.append(tr);
            let td = $("<td>" + bill.billCode + "</td>");
            tr.append(td);
            td = $("<td>" + bill.productName + "</td>");
            tr.append(td);
            td = $("<td>" + bill.productDesc + "</td>");
            tr.append(td);
            td = $("<td>" + bill.productUnit + "</td>");
            tr.append(td);
            td = $("<td>" + bill.productCount + "</td>");
            tr.append(td);
            td = $("<td>" + bill.totalPrice + "</td>");
            tr.append(td);
            td = $("<td>" + bill.isPayment + "</td>");
            tr.append(td);
            td = $("<td>" + bill.providerId.proName + "</td>");
            tr.append(td);
        }
    }

    /**
     * 处理table请求的响应值
     */
    function tableRespHandler(response) {
        let err = response.status;
        switch (err) {
            case 0: {
                drawTable(response.bills);
                break;
            }
            case 2:
            case 3:
            case 4:
            default: {
                showMsg('未知错误，请稍后再试', 'err');
                break;
            }
        }
    }

    function pageChange(btn) {
        switch (btn.innerText) {
            case '首页':
                currentPage = 1;
                break;
            case '上一页':
                currentPage--;
                if (currentPage === 0) {
                    currentPage = 1;
                }
                break;
            case '下一页':
                currentPage++;
                if (currentPage > parseInt(totalPage)) {
                    currentPage = parseInt(totalPage);
                }
                break;
            case '尾页':
                if (totalPage !== null) {
                    currentPage = parseInt(totalPage);
                }
                break;
            case '查询':
                var text = $("#num");
                currentPage = parseInt(text.val());
                if (currentPage > totalPage || currentPage < 1) {
                    alert("无效的范围！");
                    currentPage = 1;
                }
                break;
            default:
                currentPage = parseInt(btn.innerText);
        }
        console.log("当前页面为");
    }

}