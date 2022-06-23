package me.mrsterdy.AltirCraft;

import me.mrsterdy.AltirCraft.model.Server;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AltirCraftApplicationTests {

	@Test
	void serverShouldBeOnline() {
		Server server = Server.getServer();

		assertThat(server.isOnline()).isTrue();
	}

}
