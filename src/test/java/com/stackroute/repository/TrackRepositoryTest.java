package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class TrackRepositoryTest {
    @Autowired
    private TrackRepository trackRepository;
    private Track track;

    @Before
    public void setUp()
    {
        track=new Track();
        track.setTrackName("John");
        track.setTrackId(101);
        track.setTrackComments("Jenny");

    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }


    @Test
    public void testSaveUser(){
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getTrackId()).get();
        Assert.assertEquals(fetchTrack,track);

    }

    @Test
    public void testSaveUserFailure(){
        Track testMuzix = new Track(34,"Harry123","jnfkdkkd");
        trackRepository.save(track);
        Track fetchMuzix = trackRepository.findById(track.getTrackId()).get();
        Assert.assertNotSame(testMuzix,track);
    }
    //
    @Test
    public void testGetAllUser(){
        Track u = new Track(10,"Johny12","jdjsa");
        Track u1 = new Track(11,"Harry12","jwdnkjdk");
        trackRepository.save(u);
        trackRepository.save(u1);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("Johny12",list.get(0).getTrackName());




    }
//    @Test
//    public void findTitleByName() {
//    }
}