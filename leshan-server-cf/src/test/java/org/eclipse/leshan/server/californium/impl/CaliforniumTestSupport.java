/*******************************************************************************
 * Copyright (c) 2013-2015 Sierra Wireless and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 * 
 * The Eclipse Public License is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 *    http://www.eclipse.org/org/documents/edl-v10.html.
 * 
 * Contributors:
 *     Sierra Wireless - initial API and implementation
 *******************************************************************************/
package org.eclipse.leshan.server.californium.impl;

import java.net.InetAddress;
import java.net.URI;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.eclipse.leshan.server.client.Registration;

public class CaliforniumTestSupport {

    public Registration registration;
    public InetAddress destination;
    public int destinationPort = 5000;
    public URI registrationAddress;

    public void givenASimpleClient() {
        registrationAddress = URI.create("coap://localhost:5683");

        Registration.Builder builder = new Registration.Builder("ID", "urn:client", InetAddress.getLoopbackAddress(), 10000,
                registrationAddress);

        registration = builder.build();
    }

    public static byte[] createToken() {
        Random random = ThreadLocalRandom.current();
        byte[] token = new byte[8];
        // random value
        random.nextBytes(token);
        return token;
    }
}
