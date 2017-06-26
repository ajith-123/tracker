/**
 * Created by Ajith on 6/21/17.
 */
(function(){
    'use strict';
    angular.module('carTracker').service('vehicleService',vehicleService);


    vehicleService.inject=['$q','$http','CONFIG'];

    function vehicleService($q,$http,CONFIG){
        var self = this;
        self.getUsers= getUsers;

        self.getLast2hrsAlert=getLast2hrsAlert;
        function getUsers()
        {
            return $http.get(CONFIG.API_HOST+'/api/vehicles')


                .then(successFn,errorFn);

        };



        function getLast2hrsAlert()
        {
            return $http.get(CONFIG.API_HOST+'/api/alert/highPriority')


                .then(successFn,errorFn);

        };



        function getUserById(id)
        {
            return $http.get('http://mocker.egen.io/users/'+id)


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