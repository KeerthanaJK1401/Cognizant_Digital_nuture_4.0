package com.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @Mock
    ExternalAPI api;

    @InjectMocks
    MyService service;

    @Test
    void fetchData_returnsMockedValue() {
        when(api.getData()).thenReturn("Mock Data");
        assertEquals("Mock Data", service.fetchData());
    }
}
