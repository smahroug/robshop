'use strict';

angular
    .module('app.services')
    .factory('RobotService', function($http,$log){
    	
    	function getAllRobots() {
            return $http.get('api/robot/all')
                .then(function(res) {
                    return res.data;
                });
        }
    	
    	function getRobot(robotId) {
            return $http.get('api/robot/find/'+robotId)
                .then(function(res) {
                    return res.data;
                });
        }
    	
    	function createRobot(robot){
    		 return $http.post('api/robot/create', robot)
             .then(function(res) {
                 return res.data;
             });
    	}
    	
    	function updateRobot(robot){
   		 return $http.post('api/robot/update', robot)
            .then(function(res) {
                return res.data;
            });
    	}
    	
    	function removeRobot(robot){
      		 return $http.post('api/robot/delete', robot)
               .then(function(res) {
                   return res.data;
               });
       	}

        return {
        	getAllRobots: getAllRobots,
        	getRobot : getRobot,
        	createRobot : createRobot,
        	updateRobot : updateRobot,
        	removeRobot : removeRobot
        };
	
});

