<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>jsp-jqgrid</title>

    <link rel="stylesheet" href="webjars/jquery-ui-themes/1.11.4/redmond/jquery-ui.css"/>
    <link rel="stylesheet" href="webjars/font-awesome/4.5.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="webjars/free-jqgrid/4.11.1/css/ui.jqgrid.css"/>

    <style>
        html, body { font-size: 100%; }
        .ui-jqgrid .ui-jqgrid-bdiv .myAltRowClass {
            background-color: #DCFFFF;
            background-image: none;
        }
    </style>
    <script src="webjars/jquery/1.11.3/jquery.js"></script>
    <script src="webjars/jquery-ui/1.11.4/jquery-ui.min.js"></script>
    <script src="webjars/free-jqgrid/4.11.1/js/i18n/grid.locale-en.js"></script>
    <script>
        $.jgrid = $.jgrid || {};
        $.jgrid.no_legacy_api = true;
        $.jgrid.useJSON = true;
    </script>

    <script src="webjars/free-jqgrid/4.11.1/js/jquery.jqgrid.src.js"></script>

    <script>

        $(function () {
            "use strict";
            var mydata = [
                        { id: "11",  invdate: "2007-10-01", name: "test",   note: "note",   amount: 0, tax: 0, closed: true,  ship_via: "TN", total: 0 },
                        { id: "21",  invdate: "2007-10-02", name: "test2",  note: "note2",  amount: 351.75, tax: 23.45, closed: false, ship_via: "FE", total: 375.2 },
                        { id: "31",  invdate: "2007-09-01", name: "test3",  note: "note3",  amount: 400, tax: 30, closed: false, ship_via: "FE", total: 430 },
                        { id: "41",  invdate: "2007-10-04", name: "test4",  note: "note4",  amount: 200, tax: 10, closed: true,  ship_via: "TN", total: 210 },
                        { id: "51",  invdate: "2007-10-31", name: "test5",  note: "note5",  amount: 300, tax: 20, closed: false, ship_via: "FE", total: 320 },
                        { id: "61",  invdate: "2007-09-06", name: "test6",  note: "note6",  amount: 400, tax: 30, closed: false, ship_via: "FE", total: 430 },
                        { id: "71",  invdate: "2007-10-04", name: "test7",  note: "note7",  amount: 200, tax: 10, closed: true,  ship_via: "TN", total: 210 },
                        { id: "81",  invdate: "2007-10-03", name: "test8",  note: "note8",  amount: 300, tax: 20, closed: false, ship_via: "FE", total: 320 },
                        { id: "91",  invdate: "2007-09-01", name: "test9",  note: "note9",  amount: 400, tax: 30, closed: false, ship_via: "TN", total: 430 },
                        { id: "101", invdate: "2007-09-08", name: "test10", note: "note10", amount: 500, tax: 30, closed: true,  ship_via: "TN", total: 530 },
                        { id: "111", invdate: "2007-09-08", name: "test11", note: "note11", amount: 500, tax: 30, closed: false, ship_via: "FE", total: 530 },
                        { id: "121", invdate: "2007-09-10", name: "test12", note: "note12", amount: 500, tax: 30, closed: false, ship_via: "FE", total: 530 }
                    ],
                    initDateSearch = function (elem) {
                        setTimeout(function () {
                            $(elem).datepicker({
                                dateFormat: "dd-M-yy",
                                autoSize: true,
                                changeYear: true,
                                changeMonth: true,
                                showWeek: true,
                                showButtonPanel: true
                            });
                        }, 100);
                    },
                    editableInAddForm = function (options) {
                        if (options.mode === "addForm") {
                            return true;
                        }
                        if (options.mode === "editForm") {
                            return "disabled";
                        }
                        return false; // don't allows editing in other editing modes
                    },
                    $grid = $("#grid");

            $grid.jqGrid({
                data: mydata,
                colModel: [
                    { name: "name", label: "Client", width: 100,  editable: true },
                    { name: "invdate", label: "Date", width: 80, align: "center", sorttype: "date", formatter: "date", formatoptions: { newformat: "d-M-Y" }, editable: editableInAddForm, searchoptions: { sopt: ["eq", "ne", "lt", "le", "gt", "ge"], dataInit: initDateSearch } },
                    { name: "amount", label: "Amount", width: 75, template: "number" },
                    { name: "tax", label: "Tax", width: 100, template: "number", searchoptions: { sopt: ["nIn", "eq", "ne", "lt", "le", "gt", "ge", "in", "ni"] } },
                    { name: "total", label: "Total", width: 60, template: "number" },
                    { name: "closed", label: "Closed", width: 70, template: "booleanCheckboxFa", editable: editableInAddForm },
                    { name: "ship_via", label: "Shipped via", width: 105, align: "center", formatter: "select", editable: editableInAddForm, edittype: "select", editoptions: { value: "FE:FedEx;TN:TNT;IN:Intim", defaultValue: "IN" }, stype: "select", searchoptions: { sopt: ["eq", "ne"], value: ":Any;FE:FedEx;TN:TNT;IN:IN" } },
                    { name: "note", label: "Notes", width: 60, edittype: "textarea", sortable: false, editable: true }
                ],
                pager: true,
                iconSet: "fontAwesome",
                autoencode: true,
                viewrecords: true,
                rowNum: 10,
                altRows: true,
                altclass: "myAltRowClass",
                rowList: [5, 10, 20, "10000:All" ],
                caption: "Demonstration of the usage editable property of colModel as function",
                navOptions: {
                    del: false
                },
                searching: {
                    closeAfterSearch: true,
                    closeAfterReset: true,
                    closeOnEscape: true,
                    searchOnEnter: true,
                    multipleSearch: true,
                    multipleGroup: true,
                    showQuery: true
                }
            }).jqGrid("navGrid");

        });
    </script>
</head>
<body>
<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<h1>welcome root.jsp</h1>
<hr>
<h2>jpa</h2>
<a href="api" target="_blank">api</a>
<hr>

<div id="outerDiv" style="margin:5px;">
    <table id="grid"></table>
</div>
</body>
</html>