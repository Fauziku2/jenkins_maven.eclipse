package com.sddevops.jenkins_maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SongTest {
	private Song song;
	private Song song2;
	private Song song3;


	@BeforeEach
	void setUp() throws Exception {
		song = new Song("111", "Love Story", "Taylor Swift", 5.55);
	}

	@AfterEach
	void tearDown() throws Exception {
		song=null;
		song2=null;
		song3=null;

	}

	@Test
	void testHashCode() 
	{
		song = new Song("111", "Love Story", "Taylor Swift", 5.55);
		song2 = new Song("111", "Love Story", "Taylor Swift", 5.55);
		song3 = new Song("222", "Not Love Story", "Not Taylor Swift", 5.55);


		int songHash1 = song.hashCode();
		int songHash2 = song2.hashCode();
		int songHash3 = song3.hashCode();

		assertEquals(songHash1,songHash2);
		assertNotEquals(songHash1, songHash3);

				
	}

	@Test
	void testSong() {
		song2 = new Song("222", "Addicted", "Simple Plan", 5.55);
		assertEquals("Simple Plan",song2.getArtiste());
	}

	@Test
	void testGetId() {
		assertEquals("111",song.getId());
	}

	@Test
	void testSetId() {
		song.setId("555");
		assertEquals("555",song.getId());
	}

	@Test
	void testGetTitle() {
		assertEquals("Love Story",song.getTitle());
	}

	@Test
	void testSetTitle() {
		song.setTitle("Not Love story");
		assertEquals("Not Love story",song.getTitle());
	}

	@Test
	void testGetArtiste() {
		assertEquals("Taylor Swift",song.getArtiste());
	}

	@Test
	void testSetArtiste() {
		song.setArtiste("Not Taylor");
		assertEquals("Not Taylor",song.getArtiste());
	}

	@Test
	void testGetSongLength() {
		assertEquals(5.55,song.getSongLength());

	}

	@Test
	void testSetSongLength() {
		song.setSongLength(3.33);

		assertEquals(3.33,song.getSongLength());
	}

	@Test
	void testEqualsObject() {
		Song newSong3 = new Song("111", "Love Story", "Taylor Swift", 5.55);
		Song newSong4 = new Song("222", "I'm Just A Kid", "Simple Plan", 4.44);

		assertEquals(song, song);
		assertNotEquals("123", song);
		assertEquals(song, newSong3);
		assertNotEquals(song, newSong4);
	}

}
