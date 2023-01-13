/*
 * Swagger test
 * Optional multiline or single-line description in [CommonMark](http://commonmark.org/help/) or HTML.
 *
 * The version of the OpenAPI document: 0.1.9
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiCallback;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.Pair;
import org.openapitools.client.ProgressRequestBody;
import org.openapitools.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.openapitools.client.model.InlineObject;
import org.openapitools.client.model.InlineResponse200;
import org.openapitools.client.model.InlineResponse2001;
import org.openapitools.client.model.InlineResponse201;
import org.openapitools.client.model.InlineResponse400;
import org.openapitools.client.model.InlineResponse4001;
import org.openapitools.client.model.InlineResponse404;
import org.openapitools.client.model.InlineResponse4041;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultApi {
    private ApiClient localVarApiClient;

    public DefaultApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DefaultApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for apiBinUuidGet
     * @param uuid The uuid of the data-key (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A JSON array of user names </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> A JSON array with error description and status code </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> A JSON array of user names </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call apiBinUuidGetCall(String uuid, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/bin/{uuid}"
            .replaceAll("\\{" + "uuid" + "\\}", localVarApiClient.escapeString(uuid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call apiBinUuidGetValidateBeforeCall(String uuid, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'uuid' is set
        if (uuid == null) {
            throw new ApiException("Missing the required parameter 'uuid' when calling apiBinUuidGet(Async)");
        }
        

        okhttp3.Call localVarCall = apiBinUuidGetCall(uuid, _callback);
        return localVarCall;

    }

    /**
     * Returns decoded data by uuid key.
     * Optional extended description in CommonMark or HTML.
     * @param uuid The uuid of the data-key (required)
     * @return InlineResponse200
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A JSON array of user names </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> A JSON array with error description and status code </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> A JSON array of user names </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse200 apiBinUuidGet(String uuid) throws ApiException {
        ApiResponse<InlineResponse200> localVarResp = apiBinUuidGetWithHttpInfo(uuid);
        return localVarResp.getData();
    }

    /**
     * Returns decoded data by uuid key.
     * Optional extended description in CommonMark or HTML.
     * @param uuid The uuid of the data-key (required)
     * @return ApiResponse&lt;InlineResponse200&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A JSON array of user names </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> A JSON array with error description and status code </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> A JSON array of user names </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse200> apiBinUuidGetWithHttpInfo(String uuid) throws ApiException {
        okhttp3.Call localVarCall = apiBinUuidGetValidateBeforeCall(uuid, null);
        Type localVarReturnType = new TypeToken<InlineResponse200>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Returns decoded data by uuid key. (asynchronously)
     * Optional extended description in CommonMark or HTML.
     * @param uuid The uuid of the data-key (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A JSON array of user names </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> A JSON array with error description and status code </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> A JSON array of user names </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call apiBinUuidGetAsync(String uuid, final ApiCallback<InlineResponse200> _callback) throws ApiException {

        okhttp3.Call localVarCall = apiBinUuidGetValidateBeforeCall(uuid, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse200>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for apiBinUuidPut
     * @param uuid The uuid of the data-key (required)
     * @param inlineObject  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Updating existing record in db </td><td>  -  </td></tr>
        <tr><td> 201 </td><td> Creating record in db from json data and returns response with data and status code </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> A response with error message and status code. Returns one value from given example. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> A response with error message and status code </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call apiBinUuidPutCall(String uuid, InlineObject inlineObject, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = inlineObject;

        // create path and map variables
        String localVarPath = "/api/bin/{uuid}"
            .replaceAll("\\{" + "uuid" + "\\}", localVarApiClient.escapeString(uuid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call apiBinUuidPutValidateBeforeCall(String uuid, InlineObject inlineObject, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'uuid' is set
        if (uuid == null) {
            throw new ApiException("Missing the required parameter 'uuid' when calling apiBinUuidPut(Async)");
        }
        

        okhttp3.Call localVarCall = apiBinUuidPutCall(uuid, inlineObject, _callback);
        return localVarCall;

    }

    /**
     * Accepts data and store it in binary format
     * Optional extended description in CommonMark or HTML.
     * @param uuid The uuid of the data-key (required)
     * @param inlineObject  (optional)
     * @return InlineResponse2001
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Updating existing record in db </td><td>  -  </td></tr>
        <tr><td> 201 </td><td> Creating record in db from json data and returns response with data and status code </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> A response with error message and status code. Returns one value from given example. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> A response with error message and status code </td><td>  -  </td></tr>
     </table>
     */
    public InlineResponse2001 apiBinUuidPut(String uuid, InlineObject inlineObject) throws ApiException {
        ApiResponse<InlineResponse2001> localVarResp = apiBinUuidPutWithHttpInfo(uuid, inlineObject);
        return localVarResp.getData();
    }

    /**
     * Accepts data and store it in binary format
     * Optional extended description in CommonMark or HTML.
     * @param uuid The uuid of the data-key (required)
     * @param inlineObject  (optional)
     * @return ApiResponse&lt;InlineResponse2001&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Updating existing record in db </td><td>  -  </td></tr>
        <tr><td> 201 </td><td> Creating record in db from json data and returns response with data and status code </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> A response with error message and status code. Returns one value from given example. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> A response with error message and status code </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InlineResponse2001> apiBinUuidPutWithHttpInfo(String uuid, InlineObject inlineObject) throws ApiException {
        okhttp3.Call localVarCall = apiBinUuidPutValidateBeforeCall(uuid, inlineObject, null);
        Type localVarReturnType = new TypeToken<InlineResponse2001>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Accepts data and store it in binary format (asynchronously)
     * Optional extended description in CommonMark or HTML.
     * @param uuid The uuid of the data-key (required)
     * @param inlineObject  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Updating existing record in db </td><td>  -  </td></tr>
        <tr><td> 201 </td><td> Creating record in db from json data and returns response with data and status code </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> A response with error message and status code. Returns one value from given example. </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> A response with error message and status code </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call apiBinUuidPutAsync(String uuid, InlineObject inlineObject, final ApiCallback<InlineResponse2001> _callback) throws ApiException {

        okhttp3.Call localVarCall = apiBinUuidPutValidateBeforeCall(uuid, inlineObject, _callback);
        Type localVarReturnType = new TypeToken<InlineResponse2001>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
