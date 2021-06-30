package com.ch.ch11;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatSocketHandler extends TextWebSocketHandler {
	// ������ Ŭ���̾�Ʈ�� Session�� ������ ��ü
	private Map<String, WebSocketSession> users = new HashMap<String, WebSocketSession>();
	
	// ���� �Ǿ��� �� : ���� �� ����(Ŭ���̾�Ʈ)�� map�� ����
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.put(session.getId(), session);
	}
	
	// ������ ���� ���� �� : ���� �� ������ ����
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session.getId());
	}
	
	// �޼����� ���� �� : ����� ��� Ŭ���̾�Ʈ �޼����� ����
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		Collection<WebSocketSession> sessions = users.values();
		for (WebSocketSession ws : sessions) {
			ws.sendMessage(message);
		}
	}
}
