package com.example.ec.domain;

import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.core.Is.is;

/**
 * Created by Mary Ellen Bowman.
 */
public class RegionConverterTest {
    private RegionConverter converter = new RegionConverter();

    @Test
    public void convertToDatabaseColumn() throws Exception {
        assertThat(converter.convertToDatabaseColumn(Region.Central_Coast), is(Region.Central_Coast.getLabel()));
    }

    @Test
    public void convertToEntityAttribute() throws Exception {
        assertThat(converter.convertToEntityAttribute(Region.Central_Coast.getLabel()), is(Region.Central_Coast));
    }

}