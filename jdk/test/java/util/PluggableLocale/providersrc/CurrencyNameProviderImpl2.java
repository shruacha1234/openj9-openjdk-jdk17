/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
/*
 *
 */

package com.bar;

import java.util.*;
import java.util.spi.*;

import com.foobar.Utils;

public class CurrencyNameProviderImpl2 extends CurrencyNameProvider {
    static Locale[] avail = {new Locale("ja", "JP", "tokyo")};
    public Locale[] getAvailableLocales() {
        return avail;
    }

    @Override
    public String getSymbol(String c, Locale locale) {
        if (!Utils.supportsLocale(Arrays.asList(avail), locale)) {
            throw new IllegalArgumentException("locale is not supported: "+locale);
        }

        if (c.equals("JPY") && Utils.supportsLocale(avail[0], locale)) {
            return "JPY-tokyo";
        }
        return null;
    }

    @Override
    public String getDisplayName(String c, Locale locale) {
        if (!Utils.supportsLocale(Arrays.asList(avail), locale)) {
            throw new IllegalArgumentException("locale is not supported: "+locale);
        }

        if (c.equals("JPY") && Utils.supportsLocale(avail[0], locale)) {
            return "JPY-tokyo";
        }
        return null;
    }
}
