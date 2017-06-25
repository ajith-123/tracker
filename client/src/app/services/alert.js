(function(){
    'use strict';
    angular.module('carTracker').service('alertService',alertService);


    alertService.inject=['$q','$http','CONFIG'];

    function alertService($q,$http,CONFIG){
        var self = this;
        self.getAlertsByVin=getAlertsByVin;



        function getAlertsByVin(vin)
        {
            return $http.get(CONFIG.API_HOST+'/api/alert/history/'+vin)


                .then(successFn,errorFn);

        };

        function successFn(response){
            return response.data;
        }
        function errorFn(error){
            return $q.reject(error);
        }

    }


})();