/**
 * Created by HHA on 07.04.2015.
 */
function Hello($scope, $http) {
    $http.get('http://scheckcheck-satspeedy.rhcloud.com/resources/teilnehmer/1').
        success(function(data) {
            $scope.teilnehmer = data;
        });
}