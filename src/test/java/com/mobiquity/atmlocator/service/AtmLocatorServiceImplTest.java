//package com.mobiquity.atmlocator.service;
//
//import com.mobiquity.atmlocator.dto.Address;
//import com.mobiquity.atmlocator.dto.response.AtmObjResponse;
//import com.mobiquity.atmlocator.service.impl.AtmLocatorServiceImpl;
//import com.mobiquity.atmlocator.util.client.AtmRestClient;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockedStatic;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.test.util.ReflectionTestUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.mockStatic;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class AtmLocatorServiceImplTest {
//
//    @InjectMocks
//    AtmLocatorServiceImpl atmLocatorService;
//
//    @Mock
//    AtmLocatorServiceImpl atmLocatorServiceMock;
//
//    private AtmRestClient atmRestClient;
//
//    private List<AtmObjResponse> atmObjResponseList;
//
//
//    @BeforeEach
//    public void setUp() throws Exception {
//
//        /*MockitoAnnotations.initMocks(this);*/
//        AtmLocatorServiceImpl atmLocatorServiceImpl = new AtmLocatorServiceImpl();
//        ReflectionTestUtils.setField(atmLocatorServiceImpl,"atmLocatorUri","https://www.ing.nl/api/locator/atms/");
//
//        atmObjResponseList = new ArrayList<>();
//        AtmObjResponse atmObjResponse = new AtmObjResponse();
//        Address address = new Address();
//        address.setCity("GELDROP");
//        address.setHouseNumber("1");
//
//        atmObjResponse.setAddress(address);
//
//        AtmObjResponse atmObjResponse1 = new AtmObjResponse();
//        Address address1 = new Address();
//        address1.setHouseNumber("2");
//        address1.setCity("ROTTERDAM");
//
//        atmObjResponse1.setAddress(address1);
//
//        atmObjResponseList.add(atmObjResponse);
//        atmObjResponseList.add(atmObjResponse1);
//    }
//
//    @Test
//    public void findAllAtm() throws Exception {
//        //when(atmLocatorServiceMock.getAtmList(anyString())).thenReturn(atmObjResponseList);
//        try (MockedStatic<? extends AtmRestClient> mocked = mockStatic(AtmRestClient.class)) {
//            mocked.when(AtmRestClient::getInstance).thenReturn(atmRestClient);
//            mocked.when(() -> AtmRestClient.getInstance().getATMs("abc")).thenReturn(atmObjResponseList);
//            //mocked.when((MockedStatic.Verification) AtmRestClient.getInstance().getATMs(any())).thenReturn(atmObjResponseList);
//            List<AtmObjResponse> atmLocations = atmLocatorService.findAllAtm();
//            assertEquals(atmLocations.size(), 2);
//        }
//    }
//
//}