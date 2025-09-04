/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.main;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SeriesIT{

    private Series series;

    @BeforeEach
    public void setUp() {
        series = new Series();

       
        SeriesModel s = new SeriesModel("S01", "Test Show", "16", "10");


        try {
            var field = Series.class.getDeclaredField("seriesList");
            field.setAccessible(true);
            ArrayList<SeriesModel> list = (ArrayList<SeriesModel>) field.get(series);
            list.add(s);
        } catch (Exception e) {
            fail("Failed to set up test data");
        }
    }

    @Test
    public void testSeriesAddedCorrectly() {
        try {
            var field = Series.class.getDeclaredField("seriesList");
            field.setAccessible(true);
            ArrayList<SeriesModel> list = (ArrayList<SeriesModel>) field.get(series);

            assertEquals(1, list.size());
            assertEquals("S01", list.get(0).getSeriesId());
            assertEquals("Test Show", list.get(0).getSeriesName());
            assertEquals("16", list.get(0).getSeriesAge());
            assertEquals("10", list.get(0).getSeriesNumberOfEpisodes());
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateSeriesFields() {
        try {
            var field = Series.class.getDeclaredField("seriesList");
            field.setAccessible(true);
            ArrayList<SeriesModel> list = (ArrayList<SeriesModel>) field.get(series);

            SeriesModel s = list.get(0);
            s.setSeriesName("Updated Show");
            s.setSeriesAge("12");
            s.setSeriesNumberOfEpisodes("20");

            assertEquals("Updated Show", s.getSeriesName());
            assertEquals("12", s.getSeriesAge());
            assertEquals("20", s.getSeriesNumberOfEpisodes());
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    public void testDeleteSeriesSimulation() {
        try {
            var field = Series.class.getDeclaredField("seriesList");
            field.setAccessible(true);
            ArrayList<SeriesModel> list = (ArrayList<SeriesModel>) field.get(series);

            list.clear(); // simulate deletion
            assertTrue(list.isEmpty());
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }
}

