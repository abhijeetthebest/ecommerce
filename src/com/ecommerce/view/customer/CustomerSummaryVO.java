package com.ecommerce.view.customer;

import java.io.Serializable;
import com.ecommerce.view.ValueObject;

/**
 * Value object for customer summary information.
 */
public class CustomerSummaryVO implements ValueObject, Serializable {

    private static final long serialVersionUID = 1L;

    private String customerId;
    private String customerCode;
    private String customerName;
    private String customerBirthDate;
    private String customerAge;
    private String customerJoinedDate;
    private String preferredLanguage;
    private String[] specialAssistanceIndicator;
    private String testCustomerIndicator;

    private String primaryAddress;
    private String primaryCity;
    private String primaryState;
    private String primaryZip;

    private String shippingAddress;
    private String shippingCity;
    private String shippingState;
    private String shippingZip;

    private String billingAddress;
    private String billingCity;
    private String billingState;
    private String billingZip;

    private String dayPhone;
    private String eveningPhone;
    private String mobilePhone;
    private String email;

    private String customerType;
    private String loyaltyLevel;
    private String marketingOptIn;

    private String customerNumber;
    private String recommendationEngineURL;
    private boolean prospect;
    private boolean displayB2BInfo;

    /**
     * Default constructor.
     */
    public CustomerSummaryVO() {
        // Default constructor
    }

    /**
     * Get the customer ID.
     *
     * @return The customer ID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Set the customer ID.
     *
     * @param customerId The customer ID
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Get the customer code.
     *
     * @return The customer code
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * Set the customer code.
     *
     * @param customerCode The customer code
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    /**
     * Get the customer name.
     *
     * @return The customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Set the customer name.
     *
     * @param customerName The customer name
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Get the customer birth date.
     *
     * @return The customer birth date
     */
    public String getCustomerBirthDate() {
        return customerBirthDate;
    }

    /**
     * Set the customer birth date.
     *
     * @param customerBirthDate The customer birth date
     */
    public void setCustomerBirthDate(String customerBirthDate) {
        this.customerBirthDate = customerBirthDate;
    }

    /**
     * Get the customer age.
     *
     * @return The customer age
     */
    public String getCustomerAge() {
        return customerAge;
    }

    /**
     * Set the customer age.
     *
     * @param customerAge The customer age
     */
    public void setCustomerAge(String customerAge) {
        this.customerAge = customerAge;
    }

    /**
     * Get the customer joined date.
     *
     * @return The customer joined date
     */
    public String getCustomerJoinedDate() {
        return customerJoinedDate;
    }

    /**
     * Set the customer joined date.
     *
     * @param customerJoinedDate The customer joined date
     */
    public void setCustomerJoinedDate(String customerJoinedDate) {
        this.customerJoinedDate = customerJoinedDate;
    }

    /**
     * Get the preferred language.
     *
     * @return The preferred language
     */
    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    /**
     * Set the preferred language.
     *
     * @param preferredLanguage The preferred language
     */
    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    /**
     * Get the special assistance indicator.
     *
     * @return The special assistance indicator
     */
    public String[] getSpecialAssistanceIndicator() {
        return specialAssistanceIndicator;
    }

    /**
     * Set the special assistance indicator.
     *
     * @param specialAssistanceIndicator The special assistance indicator
     */
    public void setSpecialAssistanceIndicator(String[] specialAssistanceIndicator) {
        this.specialAssistanceIndicator = specialAssistanceIndicator;
    }

    /**
     * Get the test customer indicator.
     *
     * @return The test customer indicator
     */
    public String getTestCustomerIndicator() {
        return testCustomerIndicator;
    }

    /**
     * Set the test customer indicator.
     *
     * @param testCustomerIndicator The test customer indicator
     */
    public void setTestCustomerIndicator(String testCustomerIndicator) {
        this.testCustomerIndicator = testCustomerIndicator;
    }

    /**
     * Get the primary address.
     *
     * @return The primary address
     */
    public String getPrimaryAddress() {
        return primaryAddress;
    }

    /**
     * Set the primary address.
     *
     * @param primaryAddress The primary address
     */
    public void setPrimaryAddress(String primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    /**
     * Get the primary city.
     *
     * @return The primary city
     */
    public String getPrimaryCity() {
        return primaryCity;
    }

    /**
     * Set the primary city.
     *
     * @param primaryCity The primary city
     */
    public void setPrimaryCity(String primaryCity) {
        this.primaryCity = primaryCity;
    }

    /**
     * Get the primary state.
     *
     * @return The primary state
     */
    public String getPrimaryState() {
        return primaryState;
    }

    /**
     * Set the primary state.
     *
     * @param primaryState The primary state
     */
    public void setPrimaryState(String primaryState) {
        this.primaryState = primaryState;
    }

    /**
     * Get the primary zip.
     *
     * @return The primary zip
     */
    public String getPrimaryZip() {
        return primaryZip;
    }

    /**
     * Set the primary zip.
     *
     * @param primaryZip The primary zip
     */
    public void setPrimaryZip(String primaryZip) {
        this.primaryZip = primaryZip;
    }

    /**
     * Get the shipping address.
     *
     * @return The shipping address
     */
    public String getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Set the shipping address.
     *
     * @param shippingAddress The shipping address
     */
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Get the shipping city.
     *
     * @return The shipping city
     */
    public String getShippingCity() {
        return shippingCity;
    }

    /**
     * Set the shipping city.
     *
     * @param shippingCity The shipping city
     */
    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    /**
     * Get the shipping state.
     *
     * @return The shipping state
     */
    public String getShippingState() {
        return shippingState;
    }

    /**
     * Set the shipping state.
     *
     * @param shippingState The shipping state
     */
    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    /**
     * Get the shipping zip.
     *
     * @return The shipping zip
     */
    public String getShippingZip() {
        return shippingZip;
    }

    /**
     * Set the shipping zip.
     *
     * @param shippingZip The shipping zip
     */
    public void setShippingZip(String shippingZip) {
        this.shippingZip = shippingZip;
    }

    /**
     * Get the billing address.
     *
     * @return The billing address
     */
    public String getBillingAddress() {
        return billingAddress;
    }

    /**
     * Set the billing address.
     *
     * @param billingAddress The billing address
     */
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * Get the billing city.
     *
     * @return The billing city
     */
    public String getBillingCity() {
        return billingCity;
    }

    /**
     * Set the billing city.
     *
     * @param billingCity The billing city
     */
    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    /**
     * Get the billing state.
     *
     * @return The billing state
     */
    public String getBillingState() {
        return billingState;
    }

    /**
     * Set the billing state.
     *
     * @param billingState The billing state
     */
    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    /**
     * Get the billing zip.
     *
     * @return The billing zip
     */
    public String getBillingZip() {
        return billingZip;
    }

    /**
     * Set the billing zip.
     *
     * @param billingZip The billing zip
     */
    public void setBillingZip(String billingZip) {
        this.billingZip = billingZip;
    }

    /**
     * Get the day phone.
     *
     * @return The day phone
     */
    public String getDayPhone() {
        return dayPhone;
    }

    /**
     * Set the day phone.
     *
     * @param dayPhone The day phone
     */
    public void setDayPhone(String dayPhone) {
        this.dayPhone = dayPhone;
    }

    /**
     * Get the evening phone.
     *
     * @return The evening phone
     */
    public String getEveningPhone() {
        return eveningPhone;
    }

    /**
     * Set the evening phone.
     *
     * @param eveningPhone The evening phone
     */
    public void setEveningPhone(String eveningPhone) {
        this.eveningPhone = eveningPhone;
    }

    /**
     * Get the mobile phone.
     *
     * @return The mobile phone
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Set the mobile phone.
     *
     * @param mobilePhone The mobile phone
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * Get the email.
     *
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email.
     *
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the loyalty level.
     *
     * @return The loyalty level
     */
    public String getLoyaltyLevel() {
        return loyaltyLevel;
    }

    /**
     * Set the loyalty level.
     *
     * @param loyaltyLevel The loyalty level
     */
    public void setLoyaltyLevel(String loyaltyLevel) {
        this.loyaltyLevel = loyaltyLevel;
    }

    /**
     * Get the marketing opt-in.
     *
     * @return The marketing opt-in
     */
    public String getMarketingOptIn() {
        return marketingOptIn;
    }

    /**
     * Set the marketing opt-in.
     *
     * @param marketingOptIn The marketing opt-in
     */
    public void setMarketingOptIn(String marketingOptIn) {
        this.marketingOptIn = marketingOptIn;
    }

    /**
     * Check if the customer is a prospect.
     *
     * @return True if the customer is a prospect, false otherwise
     */
    public boolean isProspect() {
        return prospect;
    }

    /**
     * Set whether the customer is a prospect.
     *
     * @param prospect True if the customer is a prospect, false otherwise
     */
    public void setProspect(boolean prospect) {
        this.prospect = prospect;
    }

    /**
     * Get the customer type.
     *
     * @return The customer type
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * Set the customer type.
     *
     * @param customerType The customer type
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    /**
     * Get the recommendation engine URL.
     *
     * @return The recommendation engine URL
     */
    public String getRecommendationEngineURL() {
        return recommendationEngineURL;
    }

    /**
     * Set the recommendation engine URL.
     *
     * @param recommendationEngineURL The recommendation engine URL
     */
    public void setRecommendationEngineURL(String recommendationEngineURL) {
        this.recommendationEngineURL = recommendationEngineURL;
    }
}
