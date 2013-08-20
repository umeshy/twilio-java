package com.twilio.sdk.resource.list;

import java.util.Map;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.TwilioRestResponse;
import com.twilio.sdk.resource.ListResource;
import com.twilio.sdk.resource.factory.CredentialFactory
import com.twilio.sdk.resource.instance.Credential;

// TODO: Auto-generated Javadoc
/**
 * The Class CredentialList
 *
 * For more information see <a href="http://www.twilio.com/docs/api/rest/sip-domain">http://www.twilio.com/docs/api/rest/sip-domain</a>
 */
public class CredentialList extends ListResource<Credential> implements CredentialFactory {

    private String requestCredentialListSid;

	/**
	 * Instantiates a new sip domain list.
	 *
	 * @param client the client
	 */
	public CredentialList(TwilioRestClient client) {
		super(client);
	}

	/**
	 * Instantiates a new sip domain list.
	 *
	 * @param client the client
	 */
	public CredentialList(TwilioRestClient client, String credentialListSid) {
		super(client);
        this.requestCredentialListSid = credentialListSid;
	}

	/**
	 * Instantiates a new sip domain list.
	 *
	 * @param client the client
	 * @param filters the filters
	 */
	public CredentialList(TwilioRestClient client, Map<String, String> filters) {
		super(client, filters);
	}

	/* (non-Javadoc)
	 * @see com.twilio.sdk.resource.Resource#getResourceLocation()
	 */
	@Override
	protected String getResourceLocation() {
		return "/" + TwilioRestClient.DEFAULT_VERSION
            + "/Accounts/" + this.getRequestAccountSid()
            + "/SIP/CredentialLists/" + this.getRequestCredentialListSid()
            + "/.json";
	}

	/* (non-Javadoc)
	 * @see com.twilio.sdk.resource.ListResource#makeNew(com.twilio.sdk.TwilioRestClient, java.util.Map)
	 */
	@Override
	protected Credential makeNew(TwilioRestClient client, Map<String, Object> params) {
		return new Credential(client, params);
	}

	/* (non-Javadoc)
	 * @see com.twilio.sdk.resource.ListResource#getListKey()
	 */
	@Override
	protected String getListKey() {
		return "credentials";
	}

    /**
     * Returns the sid of the containing credential list.
     *
     * @return the credential list sid
     */
    public String getRequestCredentialListSid() {
        return this.requestCredentialListSid;
    }


	/* (non-Javadoc)
	 * @see com.twilio.sdk.resource.factory.CredentialFactory#create(java.util.Map)
	 */
	public Credential create(Map<String, String> params) throws TwilioRestException {
		TwilioRestResponse response = this.getClient().safeRequest(
				this.getResourceLocation(), "POST", params);
		return makeNew(this.getClient(), response.toMap());
	}

}
