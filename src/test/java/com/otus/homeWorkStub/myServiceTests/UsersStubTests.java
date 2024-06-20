package com.otus.homeWorkStub.myServiceTests;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.otus.homeWorkStub.dataProviders.UsersTestData;
import com.otus.homeWorkStub.models.CourseModel;
import com.otus.homeWorkStub.models.UserModel;
import com.otus.homeWorkStub.resolvers.Endpoints;
import com.otus.homeWorkStub.resolvers.EndpointsResolver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class UsersStubTests extends BaseStubTests {


  @Test(dataProvider = "getUserStubData", dataProviderClass = UsersTestData.class)
  public static void testGetUser(UserModel userModel) throws IOException {
    String userEndpoint = EndpointsResolver.resolveEndpoint(Endpoints.GET_USER);
    buildStub(urlMatching(userEndpoint + "[0-9]+"), userModel, 200);
    String response = sendRequest(userEndpoint + "1");
    UserModel user = null;
    try {
      user = objectMapper.readValue(response, UserModel.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    Assert.assertTrue(user.equals(userModel));
  }

  @Test(dataProvider = "getCoursesData", dataProviderClass = UsersTestData.class)
  public static void testGetCourses(List<CourseModel> courses) throws IOException {
    String endpoint = EndpointsResolver.resolveEndpoint(Endpoints.ALL_COURSES);
    buildStub(urlEqualTo(endpoint), courses, 200);
    String response = sendRequest(endpoint);
    CourseModel[] gotCourses = null;
    try {
      gotCourses = objectMapper.readValue(response, CourseModel[].class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    Assert.assertTrue(Arrays.asList(gotCourses).containsAll(courses) && Arrays.asList(gotCourses).size() == courses.size());
  }

  @Test(dataProvider = "getUsersStubData", dataProviderClass = UsersTestData.class)
  public static void testUsersTestData(List<UserModel> users) throws IOException {
    String endpoint = EndpointsResolver.resolveEndpoint(Endpoints.ALL_USERS);
    buildStub(urlEqualTo("/users/get/all"), users, 200);
    String response = sendRequest(endpoint);
    UserModel[] gotUsers = null;
    try {
      gotUsers = objectMapper.readValue(response, UserModel[].class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    Assert.assertTrue(Arrays.asList(gotUsers).containsAll(users) && Arrays.asList(gotUsers).size() == users.size());
  }


}
