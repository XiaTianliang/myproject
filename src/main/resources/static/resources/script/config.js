var REST_API = "";
var GATEWAY_API = "http://etrace-gw.alpha.elenet.me:9000";
var URL_DATE_FORMAT = "YYYY-MM-DD_HH:mm";

var leftMenu =
    [
        {path: "/cluster", text: "Cluster"},
        {path: "/event", text: "Event Stream"},
        {path: "/pipeline", text: "Pipeline"},
        {path: "/policy", text: "Policy"},
        {path: "/overall", text: "Overall"},
        {path: "/monitor", text: "Monitor",keep: ['startTime', 'period', 'pipeline']}
    ];
var periods = {
    1: 'Last 1 Hour',
    3: 'Last 3 Hour',
    6: 'Last 6 Hour',
    12: 'Last 12 Hour',
    24: 'Last 1 Day',
    72: 'Last 3 Day',
    168: 'Last 7 Day'
};
var periodList = [
    {period: 1, desc: 'Last 1 Hour'},
    {period: 3, desc: 'Last 3 Hour'},
    {period: 6, desc: 'Last 6 Hour'},
    {period: 12, desc: 'Last 12 Hour'},
    {period: 24, desc: 'Last 1 Day'},
    {period: 72, desc: 'Last 3 Day'},
    {period: 168, desc: 'Last 7 Day'}
];
var purchaseOrderStatus=[
    'wait_delivery',
    'delivering',
    'received'
];
var deliveryOrderStatus=[
    'delivering',
    'received',
];
