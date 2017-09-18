/*
 * Copyright (C) 2017 Black Duck Software Inc.
 * http://www.blackducksoftware.com/
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Black Duck Software ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Black Duck Software.
 */
package com.blackducksoftware.integration.hub.detect.model

import org.apache.commons.lang3.StringUtils
import org.junit.Assert
import org.junit.Test

import com.blackducksoftware.integration.util.IntegrationEscapeUtil

class DetectCodeLocationTest {

    @Test
    public void createBdioFilenameShortTest() {
        final DetectCodeLocation detectCodeLocation = new DetectCodeLocation(BomToolType.NPM, "", null, null)
        IntegrationEscapeUtil integrationEscapeUtil = new IntegrationEscapeUtil()
        String actual = detectCodeLocation.createBdioFilename(integrationEscapeUtil, "test", "short", "name")
        String expected = "NPM_short_name_test_bdio.jsonld"
        Assert.assertEquals(expected, actual)
    }

    @Test
    public void createBdioFilenameLongTest() {
        final DetectCodeLocation detectCodeLocation = new DetectCodeLocation(BomToolType.NPM, "", null, null)
        IntegrationEscapeUtil integrationEscapeUtil = new IntegrationEscapeUtil()
        String longPath = StringUtils.repeat('a', 150)
        String longVersion = StringUtils.repeat('b', 250)
        String actual = detectCodeLocation.createBdioFilename(integrationEscapeUtil, longPath, "short", longVersion)
        String expected = "NPM_short_973970240_334320992_bdio.jsonld"
        Assert.assertEquals(expected, actual)
    }
}
