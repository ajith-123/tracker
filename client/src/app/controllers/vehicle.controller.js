(function(){
    'use strict';
    angular.module('carTracker').controller('VehicleController',VehicleController)
    VehicleController.$inject=['vehicleService'];
    function VehicleController(vehicleService){
        var carVm = this;
        carVm.sorter={
            sortBy:'redLineRpm',
            reverse:true
        };
        vehicleService.getUsers().then(function(response){
            carVm.users=response;

        },function(error){
            console.log(error);
        });

        vehicleService.getUserById('e44acdd9-1a4c-4955-b4bd-b64bee56b988').then(function(response){
            console.log(response);
        },function(error){
            console.log(error);
        });
    }
})();