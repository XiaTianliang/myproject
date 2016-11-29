angular.module("DataLoad", [])
    .factory("DataLoadService", ['$http', '$q',
        function ($http, $q) {
            return {
                get: function (url) {
                    return $http({
                        method: 'GET', url: REST_API + url,
                        //headers: {
                        //    'Content-Type':'text/plain'
                        //}
                        transformResponse: appendTransform($http.defaults.transformResponse, function (value) {
                            return value;
                        })
                    });
                },
                get: function (url, params) {
                    return $http({
                        method: 'GET',
                        url: REST_API + url,
                        params: params
                    });
                },
                put: function (url, params) {
                    return $http({
                        method: 'PUT',
                        url: REST_API + url,
                        data: params,
                        contentType: "application/json; charset=utf-8"
                    });
                },
                post: function (url, params) {
                    return $http({
                        method: 'POST',
                        url: REST_API + url,
                        data: params,
                        contentType: "application/json; charset=utf-8"
                    });
                },
                //used for case swal is not needed
                del: function(url){
                    return $http({
                        url:REST_API + url,
                        method:'DELETE',
                        contentType: "application/json; charset=utf-8"
                    })
                },
                del: function (url, msg, success) {
                    swal({
                        type: 'warning',
                        title: "Confirm delete",
                        text: msg,
                        showCancelButton: true,
                        confirmButtonText: 'Yes, delete it!'
                    }).then(function () {
                        var deleteReq = $http({
                            method: 'DELETE',
                            url: REST_API + url
                        });
                        $q.when(deleteReq).then(function (response) {
                            if (success) {
                                success(response);
                            }
                        }, function (response) {
                            swalFailure(response);
                        });
                    }).done();
                },
                loadMessage: function (params) {
                    window.open('/callstack.html#/callstack?uniqueId=' + params.uniqueId + '&timestamp=' + params.timestamp, '_blank');
                },
                save: function (url, params, success, failure) {
                    //judge first
                    var already_exits = false;
                    if(params['productId'] && params['supermarketId']){
                        already_exits =  (params['orderId'] || params['inventoryId']);
                    }else{
                        already_exits = params['productId'];
                    }
                    if(!already_exits){
                        $q.when(this.post(url, params)).then(function (response) {
                            if (success) {
                                success(response);
                            }
                        }, function (response) {
                            if (failure) {
                                failure(response);
                            }
                            swalFailure(response);
                        });
                    } else {
                        $q.when(this.put(url, params)).then(function (response) {
                            if (success) {
                                success(response);
                            }
                        }, function (response) {
                            if (failure) {
                                failure(response);
                            }
                            swalFailure(response);
                        });
                    }
                }
            }
        }]
);
function appendTransform(defaults, transform) {

    // We can't guarantee that the default transformation is an array
    defaults = angular.isArray(defaults) ? defaults : [defaults];

    // Append the new transformation to the defaults
    return defaults.concat(transform);
}