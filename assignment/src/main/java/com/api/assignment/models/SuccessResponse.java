/*
 * Authentication API
 * The signup module has an action API, which is used for the following reasons. 1) To initiate the login page, if authentication is applicable for the  user, during action authorize  granting access to the system . 2) To validate the login, along with the password of the user 3) To cancel the request  when authentication process is cancelled .4) To support the actions login and logout mechanism
 *
 * OpenAPI spec version: 1.0.0
 * Contact: rubiyakadarbasha@gmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.api.assignment.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * SuccessResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-02-28T18:07:05.498+05:30")
public class SuccessResponse {
  @JsonProperty("resCode")
  private String resCode = null;

  @JsonProperty("resMsg")
  private String resMsg = null;

  public SuccessResponse resCode(String resCode) {
    this.resCode = resCode;
    return this;
  }

   /**
   * Indicates the response code
   * @return resCode
  **/
  @ApiModelProperty(required = true, value = "Indicates the response code")
  public String getResCode() {
    return resCode;
  }

  public void setResCode(String resCode) {
    this.resCode = resCode;
  }

  public SuccessResponse resMsg(String resMsg) {
    this.resMsg = resMsg;
    return this;
  }

   /**
   * Indicates the response message
   * @return resMsg
  **/
  @ApiModelProperty(required = true, value = "Indicates the response message")
  public String getResMsg() {
    return resMsg;
  }

  public void setResMsg(String resMsg) {
    this.resMsg = resMsg;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponse successResponse = (SuccessResponse) o;
    return Objects.equals(this.resCode, successResponse.resCode) &&
        Objects.equals(this.resMsg, successResponse.resMsg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resCode, resMsg);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponse {\n");
    
    sb.append("    resCode: ").append(toIndentedString(resCode)).append("\n");
    sb.append("    resMsg: ").append(toIndentedString(resMsg)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

