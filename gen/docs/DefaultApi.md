# DefaultApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**apiBinUuidGet**](DefaultApi.md#apiBinUuidGet) | **GET** /api/bin/{uuid} | Returns decoded data by uuid key.
[**apiBinUuidPut**](DefaultApi.md#apiBinUuidPut) | **PUT** /api/bin/{uuid} | Accepts data and store it in binary format


<a name="apiBinUuidGet"></a>
# **apiBinUuidGet**
> InlineResponse200 apiBinUuidGet(uuid)

Returns decoded data by uuid key.

Optional extended description in CommonMark or HTML.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String uuid = "uuid_example"; // String | The uuid of the data-key
    try {
      InlineResponse200 result = apiInstance.apiBinUuidGet(uuid);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#apiBinUuidGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| The uuid of the data-key |

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | A JSON array of user names |  -  |
**400** | A JSON array with error description and status code |  -  |
**404** | A JSON array of user names |  -  |

<a name="apiBinUuidPut"></a>
# **apiBinUuidPut**
> InlineResponse2001 apiBinUuidPut(uuid, inlineObject)

Accepts data and store it in binary format

Optional extended description in CommonMark or HTML.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String uuid = "uuid_example"; // String | The uuid of the data-key
    InlineObject inlineObject = new InlineObject(); // InlineObject | 
    try {
      InlineResponse2001 result = apiInstance.apiBinUuidPut(uuid, inlineObject);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#apiBinUuidPut");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| The uuid of the data-key |
 **inlineObject** | [**InlineObject**](InlineObject.md)|  | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Updating existing record in db |  -  |
**201** | Creating record in db from json data and returns response with data and status code |  -  |
**400** | A response with error message and status code. Returns one value from given example. |  -  |
**404** | A response with error message and status code |  -  |

