package controllers;

import models.Model;
import play.mvc.WebSocket;
import akka.actor.UntypedActor;

public class StatusWS extends UntypedActor {
    WebSocket.In<String> in;
    WebSocket.Out<String> out;
	//private static Collection<WebSocket.Out<String>> connections = new ArrayList<WebSocket.Out<String>>(); 


    public StatusWS(WebSocket.In<String> in, WebSocket.Out<String> out) {
	//	connections.add(out);
    	this.in = in;
        this.out = out;
    }

    @Override
    public void onReceive(Object message) {
        if (message.equals("Status")) {
//        	for (WebSocket.Out<String> out : connections) {
        		out.write(Model.leseStatus());
  //      	}
        } else {
            unhandled(message);
        }
    }
}