/**
 * Copyright 2016-2017 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.specification.nukleus.ws.streams;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.rules.RuleChain.outerRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.kaazing.k3po.junit.annotation.Specification;
import org.kaazing.k3po.junit.rules.K3poRule;
import org.reaktivity.specification.nukleus.NukleusRule;

/**
 * RFC-6455, section 5.2 "Base Framing Protocol"
 */
public class BaseFramingIT
{
    private final K3poRule k3po = new K3poRule()
        .addScriptRoot("streams", "org/reaktivity/specification/nukleus/ws/streams/framing")
        .addScriptRoot("ws", "org/kaazing/specification/ws/opening");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    private final NukleusRule nukleus = new NukleusRule()
        .directory("target/nukleus-itests")
        .streams("ws", "source")
        .streams("target", "ws#source")
        .streams("ws", "target")
        .streams("source", "ws#target");

    @Rule
    public final TestRule chain = outerRule(nukleus).around(k3po).around(timeout);

    @Test
    @Specification({
        "${streams}/echo.binary.payload.length.0/server/source",
        "${streams}/echo.binary.payload.length.0/server/nukleus",
        "${streams}/echo.binary.payload.length.0/server/target" })
    public void shouldEchoBinaryFrameWithPayloadLength0() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_INPUT");
        k3po.notifyBarrier("ROUTED_OUTPUT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/echo.binary.payload.length.125/server/source",
        "${streams}/echo.binary.payload.length.125/server/nukleus",
        "${streams}/echo.binary.payload.length.125/server/target" })
    public void shouldEchoBinaryFrameWithPayloadLength125() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_INPUT");
        k3po.notifyBarrier("ROUTED_OUTPUT");
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/echo.binary.payload.length.126/handshake.request.and.frame",
        "${streams}/echo.binary.payload.length.126/handshake.response.and.frame" })
    public void shouldEchoBinaryFrameWithPayloadLength126() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/echo.binary.payload.length.127/handshake.request.and.frame",
        "${streams}/echo.binary.payload.length.127/handshake.response.and.frame" })
    public void shouldEchoBinaryFrameWithPayloadLength127() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/echo.binary.payload.length.128/handshake.request.and.frame",
        "${streams}/echo.binary.payload.length.128/handshake.response.and.frame" })
    public void shouldEchoBinaryFrameWithPayloadLength128() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/echo.binary.payload.length.65535/handshake.request.and.frame",
        "${streams}/echo.binary.payload.length.65535/handshake.response.and.frame" })
    public void shouldEchoBinaryFrameWithPayloadLength65535() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/echo.binary.payload.length.65536/handshake.request.and.frame",
        "${streams}/echo.binary.payload.length.65536/handshake.response.and.frame" })
    public void shouldEchoBinaryFrameWithPayloadLength65536() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/echo.text.payload.length.0/handshake.request.and.frame",
        "${streams}/echo.text.payload.length.0/handshake.response.and.frame" })
    public void shouldEchoTextFrameWithPayloadLength0() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/echo.text.payload.length.125/handshake.request.and.frame",
        "${streams}/echo.text.payload.length.125/handshake.response.and.frame" })
    public void shouldEchoTextFrameWithPayloadLength125() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/echo.text.payload.length.126/handshake.request.and.frame",
        "${streams}/echo.text.payload.length.126/handshake.response.and.frame" })
    public void shouldEchoTextFrameWithPayloadLength126() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/echo.text.payload.length.127/handshake.request.and.frame",
        "${streams}/echo.text.payload.length.127/handshake.response.and.frame" })
    public void shouldEchoTextFrameWithPayloadLength127() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/echo.text.payload.length.128/handshake.request.and.frame",
        "${streams}/echo.text.payload.length.128/handshake.response.and.frame" })
    public void shouldEchoTextFrameWithPayloadLength128() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/echo.text.payload.length.65535/handshake.request.and.frame",
        "${streams}/echo.text.payload.length.65535/handshake.response.and.frame" })
    public void shouldEchoTextFrameWithPayloadLength65535() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${streams}/echo.text.payload.length.65536/handshake.request.and.frame",
        "${streams}/echo.text.payload.length.65536/handshake.response.and.frame" })
    public void shouldEchoTextFrameWithPayloadLength65536() throws Exception
    {
        k3po.finish();
    }
}
