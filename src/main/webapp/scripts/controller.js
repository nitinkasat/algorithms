var sort = {
	input : "12,13",
	output : ""
};

var appname = angular.module('algorithms', []);
appname.controller('sortingController', [ '$scope', function($scope) {
	$scope.sort = sort;
} ]);