/*
 * Abstract2StageLocator.java
 * 
 * Copyright (c) 2011, Ralf Biedert, DFKI. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 * 
 * Redistributions of source code must retain the above copyright notice, this list of
 * conditions and the following disclaimer. Redistributions in binary form must reproduce the
 * above copyright notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of the author nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS
 * OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 */
package net.xeoh.nexus;

import java.util.Collection;

/**
 * A 2StageLocator is a locator that in a first stage is able to list the
 * plugin {@link Candidate} objects it would locate as an actual {@link Service}.
 * 
 * @author Ralf Biedert
 * @since 1.0
 */
public abstract class Abstract2StageLocator extends AbstractLocator {
    /** A whitelist of elements to consider */
    protected Collection<String> whitelist;

    /** A blacklist of elements not to consider */
    protected Collection<String> blacklist;

    /**
     * Returns a list of {@link Candidate} objects this locator would
     * locate as {@link Service} objects when <code>locate()</code> is 
     * being called.
     * 
     * @since 1.0
     * @return A list of candidates.
     */
    public abstract Collection<Candidate> candidates();

    /**
     * Only locates the given candidates.
     * 
     * @since 1.0
     * @param candidates The candidates to locate.
     * @return A list of located {@link Service} objects.
     */
    public abstract Collection<Service> locate(Collection<Candidate> candidates);

    /**
     * Sets the whitelist of classes to consider. If a whitelist is given, only the elements on the
     * whitelist are being considered, regardless of the classes that might otherwise be found.
     * If also a blacklist is given, only elements on the whitelist and not on the blacklist
     * are loaded.
     * 
     * @since 1.0
     * @param whitelist The whitelist to consider, a list of fully qualified class names.
     */
    @SuppressWarnings("hiding")    
    public void whitelist(Collection<String> whitelist) {
        this.whitelist = whitelist;
    }

    /**
     * Sets the blacklist of classes not to consider. If a blacklist is given, the elements on the
     * blacklist are not loaded, regardless of whether they are present on the whitelist or not.
     * 
     * @since 1.0
     * @param blacklist The blacklist of classes not to load, a list of fully qualified class names.
     */
    @SuppressWarnings("hiding")
    public void blacklist(Collection<String> blacklist) {
        this.blacklist = blacklist;
    }
}
