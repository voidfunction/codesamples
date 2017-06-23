function render(data) {
    d3.select("#myDiv").selectAll("div.h-bar")
        .data(data)
        .enter()
        .append('div')
        .style("width", function(d) {
            return (d * 10) + "px";
        })
        .attr('class', 'h-bar')
        .append("span")
        .text(function(d) {
            return d;
        });

    d3.select("#myDiv").selectAll("div.h-bar")
        .data(data)
        .style("width", function(d) {
            return (d * 3) + "px";
        }).select("span")
        .text(function(d) {
            return d;
        });


    d3.select("#myDiv").selectAll("div.h-bar")
        .data(data)
        .exit()
        .remove();
}
$(function() {
    // d3.select("#p").text("test");
    // d3.selectAll('div')
    //     .attr('class', 'redbox')
    //     .each(function(d, i) {
    //         d3.select(this).append('h1').text(i);
    //     });

    var data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
    setInterval(function() {
        data.shift();
        data.push(Math.round(Math.random() * 10));
        render(data);
    }, 1000);

    render(data);
    // d3.select("#myDiv").selectAll("div.h-bar")
    //     .data(data)
    //     .style("width", function(d) {
    //         return (d * 10) + "px";
    //     })
    //     .select("span")
    //     .text(function(d) {
    //         return d;
    //     });
});