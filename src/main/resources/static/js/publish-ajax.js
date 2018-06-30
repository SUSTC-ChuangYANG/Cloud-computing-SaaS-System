//== Class definition

var DatatableRemoteAjaxDemo = function () {
    //== Private functions

    var changeInfo = function () {

        var login = $('#m_login');

        var showErrorMsg = function (form, type, msg) {
            var alert = $('<div class="m-alert m-alert--outline alert alert-' + type + ' alert-dismissible" role="alert">\
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>\
			<span></span>\
		</div>');

            form.find('.alert').remove();
            alert.prependTo(form);
            alert.animateClass('fadeIn animated');
            alert.find('span').html(msg);
        }

        var AdminRegs = function () {
            $('#submitReg').click(function (e) {
                e.preventDefault();
                var btn = $(this);
                var form = $(this).closest('form');

                form.validate({
                    rules: {

                        // username: {
                        //     required: true,
                        // },

                        // email: {
                        //     required: true,
                        //     email: true
                        // },
                        //
                        // password: {
                        //     required: true
                        // },
                        //
                        personstatus: {
                            required: true
                        },

                        phonenumber: {
                            required: true
                        }

                    }
                });

                if (!form.valid()) {
                    return;
                }

                btn.addClass('m-loader m-loader--right m-loader--light').attr('disabled', true);

                var Phonenumber = document.getElementById("phnonen").value;

                var Personstatus = document.getElementById("persons").value;

                //var uPd = document.getElementById("u_password").value;

                form.ajaxSubmit({
                    type: "POST",
                    url: "/someurl/"+Phonenumber+Personstatus,//************************************************ need to change for the certain URL
                    success: function (json) {
                        if (true) {
                            setTimeout(function () {
                                swal({
                                    title: "Success!",
                                    text: "You have successfully change your information",
                                    type: "success"
                                }).then(function () {
                                    window.location.reload();
                                })
                                ;
                            }, 1000);
                        } else {
                            setTimeout(function () {
                                swal({
                                    title: "Error!",
                                    text: json.message,
                                    type: "error"
                                }).then(function () {
                                    var signInForm = login.find('#mainForm');
                                    signInForm.clearForm();
                                    signInForm.validate().resetForm();
                                });
                            }, 1000);
                        }
                    }
                });
            });
        }

        return {
            init: function () {
                AdminRegs();
            },
        };
    }();

    var daterangepickerInit = function () {

        if ($('#m_dashboard_daterangepicker').length == 0) {
            return;
        }

        var picker = $('#m_dashboard_daterangepicker');
        var start = moment();
        var end = moment();

        function cb(start, end, label) {
            var title = '';
            var range = '';

            if ((end - start) < 100) {
                title = 'Today:';
                range = start.format('MMM D');
            } else if (label == 'Yesterday') {
                title = 'Yesterday:';
                range = start.format('MMM D');
            } else {
                range = start.format('MMM D') + ' - ' + end.format('MMM D');
            }

            picker.find('.m-subheader__daterange-date').html(range);
            picker.find('.m-subheader__daterange-title').html(title);
        }

        picker.daterangepicker({
            startDate: start,
            endDate: end,
            opens: 'left',
            ranges: {
                'Today': [moment(), moment()],
                // 'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                // 'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                // 'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                // 'This Month': [moment().startOf('month'), moment().endOf('month')],
                // 'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
            }
        }, cb);

        cb(start, end, '');
    }

    // basic demo
    var demo = function () {
        var base_link = "http://10.20.111.242:8080/teacher/my_course/";
        var datatable = $('.m_datatable').mDatatable({
            // datasource definition
            data: {
                type: 'remote',
                source: {
                    read: {
                        // sample GET method
                        method: 'GET',
                        url: "http://10.20.111.242:8080/teacher/my_course",
                        map: function (raw) {
                            // sample data mapping
                            //var temp = eval(raw);
                            var dataSet = raw;
                            // if (typeof raw.message !== 'undefined') {
                            //   dataSet = raw.message[tasks];
                            // }
                            console.log(raw);
                            return dataSet;
                            //return '{[{"description": "this is a test project","if_finished": 0,"number": 0,"priority": 1,"publish_date": 1527402240.0,"publisher": 1,"source_id": 11,"source_name": "test_proj"},{"description": "test_desc","if_finished": 0,"number": 1,"priority": 1,"publish_date": 1527409408.0,"publisher": 2,"source_id": 12,"source_name": "test"},{"description": "xiedn single option project","if_finished": 0,"number": 11,"priority": 2,"publish_date": 1527928320.0,"publisher": 1,"source_id": 13,"source_name": "xiednproj"}]}';
                        },
                    },
                },
                pageSize: 10,
                serverPaging: false,
                serverFiltering: false,
                serverSorting: false,
            },

            // layout definition
            layout: {
                scroll: false,
                footer: false
            },

            // column sorting
            sortable: true,

            pagination: true,

            toolbar: {
                // toolbar items
                items: {
                    // pagination
                    pagination: {
                        // page size select
                        pageSizeSelect: [10, 20, 30, 50, 100],
                    },
                },
            },

            search: {
                input: $('#generalSearch'),
            },



            // columns definition
            columns: [
                {
                    field: 'course_id',
                    title: 'Course ID',
                    // sortable: 'asc', // default sort
                    filterable: false, // disable or enable filtering
                    width: 100,
                    textAlign: 'center',
                    // basic templating support for column rendering,
                    //template: '{{source_id}} - {{source_name}}',
                },
                {
                    field: 'course_code',
                    title: 'Course Code',
                    // sortable: 'asc', // default sort
                    filterable: false, // disable or enable filtering
                    width: 100,
                    textAlign: 'center',
                    // basic templating support for column rendering,
                    //template: '{{source_id}} - {{source_name}}',
                }, {
                    field: 'course_name',
                    title: 'Course Name',
                    width: 200,
                    textAlign: 'center',
                }, {
                    field: 'Actions',
                    width: 200,
                    title: 'Management',
                    sortable: false,
                    overflow: 'visible',
                    textAlign: 'center',
                    template: function (raw) {
                    return  "<a class='btn btn-focus m-btn m-btn--pill m-btn--custom m-btn--air' href='"
                             +base_link+raw.course_id + "'>\
                             <span>\
                             <i class='la la-anchor'></i>\
                             <span>\
                              Manage\
                             </span>\
                        </a>";
                    }

                }


            ],
        });

    };

    return {
        // public functions
        init: function () {
            daterangepickerInit();
            demo();
            changeInfo();

        },
    };
}();

jQuery(document).ready(function () {
    DatatableRemoteAjaxDemo.init();
});