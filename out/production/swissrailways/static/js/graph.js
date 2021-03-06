/**
 * Created by aleksandrprendota on 12.05.17.
 */
var station_data = [];
function showGraph() {
    $("#dialog").empty();
    $("#logo").empty();
    $("#fon").remove();
    $("#chartdiv").remove();
    $.ajax({
        type: "GET",
        url : '/station/allstations',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            station_data = response;
            $('#dialog').append('<div style="height: 600px; width: 600px;" id="chartdiv"></div>');
            var chart = AmCharts.makeChart( "chartdiv", {
                "type": "xy",
                "theme": "chalk",
                "balloon":{
                    "fixedPosition":true,
                },
                "dataProvider": station_data,
                "startDuration": 1.5,
                "graphs": [ {
                    "balloonText": "x:<b>[[x]]</b> y:<b>[[y]]</b><br>City:<b>[[stationName]]</b>",
                    "bullet": "circle",
                    "bulletBorderAlpha": 0.2,
                    "bulletAlpha": 0.8,
                    "lineAlpha": 0,
                    "fillAlphas": 0,
                    "valueField": "value",
                    "xField": "x",
                    "yField": "y",
                    "maxBulletSize": 100
                } ],
                "marginLeft": 46,
                "marginBottom": 35

            } );
        },
        error: function () {
            swal("Oops...", "Some problems with getting station :( Please try later", "error");
        }
    });

    goDialogGraph();

}


function goDialogGraph(){
    $( function() {
        $( "#dialog" ).dialog({
            modal: true,
            closeOnEscape: true,
            maxWidth:650,
            maxHeight: 660,
            width: 650,
            height: 660,
            resizable: false,
            title: "Graph of stations!"
        });
    } );
}