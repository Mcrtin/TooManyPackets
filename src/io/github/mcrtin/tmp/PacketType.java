package io.github.mcrtin.tmp;

public enum PacketType {
	PLAY_IN("play", "server"), PLAY_OUT("play", "client");

	private final String boundTo;
	private final String state;

	PacketType(String state, String boundTo) {
		this.state = state;
		this.boundTo = boundTo;
	}

	public String getBoundTo() {
		return boundTo;
	}

	public String getState() {
		return state;
	}
}