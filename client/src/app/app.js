/**
 * Created by Ajith on 6/21/17.
 */
(function(){
    'use strict';
    angular.module('carTracker', ['ngRoute', 'ngMap']);


    angular.module('carTracker')
        .config(moduleConfig);

    moduleConfig.$inject=['$routeProvider'];

    function moduleConfig($routeProvider){
        $routeProvider.when('/vehicles',{
            templateUrl:'app/views/vehicle-list/vehicle-list.tmpl.html',
            controller:'VehicleController',
            controllerAs:'carVm'
        })
            .when('/alerts',{
                templateUrl:'alerts/alert.tmpl.html'
            })
            .when('/vehicles/:vin',{
                templateUrl:'app/views/vehicle-detail/vehicle-detail.tmpl.html',
                controller:'VehicleDetailController',
                controllerAs:'vehicleDetailVm'
            })


            .otherwise({redirectTo:"/vehicles"});
    }
})();