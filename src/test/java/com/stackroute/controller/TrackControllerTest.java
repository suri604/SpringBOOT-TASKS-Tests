package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
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
public class TrackControllerTest {
    @Autowired
    private TrackRepository muzixRepository;
    private Track muzix;

    @Before
    public void setUp()
    {
        muzix=new Track();
        muzix.setTrackName("John");
        muzix.setTrackId(101);
        muzix.setTrackComments("Jenny");

    }

    @After
    public void tearDown(){

        muzixRepository.deleteAll();
    }


    @Test
    public void testSaveUser(){
        muzixRepository.save(muzix);
        Track fetchMuzix = muzixRepository.findById(muzix.getTrackId()).get();
        Assert.assertEquals(fetchMuzix,muzix);

    }

    @Test
    public void testSaveUserFailure(){
        Track testMuzix = new Track(34,"Harry123","jnfkdkkd");
        muzixRepository.save(muzix);
        Track fetchMuzix = muzixRepository.findById(muzix.getTrackId()).get();
        Assert.assertNotSame(testMuzix,muzix);
    }
    //
    @Test
    public void testGetAllUser(){
        Track u = new Track(10,"Johny12","jdjsa");
        Track u1 = new Track(11,"Harry12","jwdnkjdk");
        muzixRepository.save(u);
        muzixRepository.save(u1);

        List<Track> list = muzixRepository.findAll();
        Assert.assertEquals("Johny12",list.get(0).getTrackName());




    }
//    @Test
//    public void findTitleByName() {
//    }
}