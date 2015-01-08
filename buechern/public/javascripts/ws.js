$(function(){
 
    // get websocket class, firefox has a different way to get it
    var WS = window['MozWebSocket'] ? window['MozWebSocket'] : WebSocket;
    
    // open pewpew with websocket
    var socket = new WS('@routes.Application.initializeWS().webSocketURL(request)');
    
    var writeMessages = function(event){
             $('#status_feed').prepend('<p>'+event.data+'</p>');
    }
    
    socket.onmessage = writeMessages;
      
});