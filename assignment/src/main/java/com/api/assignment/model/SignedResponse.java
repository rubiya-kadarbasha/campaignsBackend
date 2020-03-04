/**
 *
 * <p>Title       		: SignedResponse</p>
 * <p>Description 		: This is a SignedResponse class which is create JWT Response</p>
 * <p>Date of Creation 	: 2020-02-19</p>
 * <p>Source      		: SignedResponse </p>
 * <p>Package     		: com.api.assignment.model</p>
 * 
 * @author Rubiya KadarBasha
 * @version 1.0
 * 
 * <p>------------------------------------------------------------------------------------</p>
 * <p>:MODIFICATION HISTORY:</p>
 * <p>------------------------------------------------------------------------------------</p>
 * <p>SERIAL  AUTHOR     DATE            SCF            DESCRIPTION</p>
 * <p>------------------------------------------------------------------------------------</p>
 * 
 * <p>------------------------------------------------------------------------------------</p>
 */

package com.api.assignment.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;


/**
 * The Class SignedResponse.
 *
 * @author rubiya.kadarbasha
 */

/**
 * Instantiates a new signed response.
 *
 * @param approvalDoc the approval doc
 */
@AllArgsConstructor
public class SignedResponse implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** approval Doc maintains the signed response. */
	private String approvalDoc;

	/**
	 * Gets the approval doc.
	 *
	 * @return approvalDoc
	 */
	public String getApprovalDoc() {
		return approvalDoc;
	}

	/**
	 * the approverResponse to set.
	 *
	 * @param approvalDoc sign doc
	 */
	public void setApprovalDoc(final String approvalDoc) {
		this.approvalDoc = approvalDoc;
	}
	
	/**
	 * The method is used to convert the signed response to json string.
	 *
	 * @return the string
	 */
	public String toString()
	{
		return "{\"approvalDoc\":\""+approvalDoc+"\"}";
	}
	
	
}
