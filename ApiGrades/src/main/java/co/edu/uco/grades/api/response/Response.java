package co.edu.uco.grades.api.response;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;

public class Response <D>{

	private List<D> data;
	private List<String> messages;
	
	public List<D> getData() {
		return data;
	}
	
	public  Response <D> build(){
		
		return new Response<>();
	}
	public void setData(List<D> data) {
		this.data = UtilObject.getUtilObject().getDefault(data, new ArrayList<>());
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = UtilObject.getUtilObject().getDefault(messages, new ArrayList<>());
	}
	private Response(List<D> data, List<String> messages) {
		super();
	setData( data);
		setMessages(messages);
	}
public Response() {
	super();
	setData(new ArrayList<>());
	setMessages(new ArrayList<>());
}
	
}
