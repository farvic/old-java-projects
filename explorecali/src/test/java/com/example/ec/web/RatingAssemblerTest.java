package com.example.ec.web;

import com.example.ec.domain.Tour;
import com.example.ec.domain.TourRating;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Link;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RatingAssemblerTest {
    // private static final int TOUR_ID = 999;
    private static final int RATING_ID = 555;

    private static final int CUSTOMER_ID = 1000;
    private static final int SCORE = 3;
    private static final String COMMENT = "comment";

    @Mock
    private RepositoryEntityLinks entityLinksMock;
    @InjectMocks
    private RatingAssembler assembler;

    @Test
    public void toResource() {
        TourRating tourRatingMock = mock(TourRating.class);
        Tour tourMock = mock(Tour.class);
        Link linkMock = mock(Link.class);
        when(tourRatingMock.getComment()).thenReturn(COMMENT);
        when(tourRatingMock.getScore()).thenReturn(SCORE);
        when(tourRatingMock.getCustomerId()).thenReturn(CUSTOMER_ID);
        when(tourRatingMock.getId()).thenReturn(RATING_ID);
        when(tourRatingMock.getTour()).thenReturn(tourMock);
        when(entityLinksMock.linkToItemResource(any(Class.class), anyInt())).thenReturn(linkMock);
        when(linkMock.withRel(anyString())).thenReturn(linkMock);
        RatingDto dto = assembler.toModel(tourRatingMock);
        assertTrue(dto.getLinks().hasSize(2));
    }
}