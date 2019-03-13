var clients = [
    { "Name": "Otto Clay", "Age": 25, "Country": 1, "Address": "Ap #897-1459 Quam Avenue", "Married": false },
    { "Name": "Connor Johnston", "Age": 45, "Country": 2, "Address": "Ap #370-4647 Dis Av.", "Married": true },
    { "Name": "Lacey Hess", "Age": 29, "Country": 3, "Address": "Ap #365-8835 Integer St.", "Married": false },
    { "Name": "Timothy Henson", "Age": 56, "Country": 1, "Address": "911-5143 Luctus Ave", "Married": true },
    { "Name": "Ramona Benton", "Age": 32, "Country": 3, "Address": "Ap #614-689 Vehicula Street", "Married": false }
];

var countries = [
    { Name: "", Id: 0 },
    { Name: "United States", Id: 1 },
    { Name: "Canada", Id: 2 },
    { Name: "United Kingdom", Id: 3 }
];

$("#jsGrid").jsGrid({
    width: "100%",
    height: "400px",

    inserting: true,
    editing: true,
    sorting: true,
    paging: true,
    pageSize: 10,
    autoload: true,
    pageLoading: true,

    controller: {
        loadData: function (filter) {
            var d = $.Deferred();
            $.ajax({
                url: "/products",
                data: {
                    page: filter.pageIndex - 1,
                    size: filter.pageSize
                },
                dataType: "json",
                success: function (response) {
                    d.resolve({
                        data: response._embedded.products,
                        itemsCount: response.page.totalElements
                    });
                },
                error: function () {
                    d.resolve();
                }
            });
            return d.promise();
        }
    },

    fields: [
        // { name: "id", type: "text", width: 150, validate: "required" },
        { name: "name", type: "text", width: 150 },
        { name: "categories", type: "text", width: 50 },
        { name: "unit", type: "text", width: 200, validate: "required"  },
        { name: "increment", type: "text", validate: "required" },
        { type: "control" }
    ]
});