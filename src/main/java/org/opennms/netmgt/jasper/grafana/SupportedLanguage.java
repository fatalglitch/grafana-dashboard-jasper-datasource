/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2015 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2015 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.netmgt.jasper.grafana;


import net.sf.jasperreports.engine.query.QueryExecuterFactory;

/**
 * These are the supported "query languages" to be used within Jasper Report (*.jrxml) files.
 */
public enum SupportedLanguage {
    Grafana(new GrafanaExecutorFactory());

    private final QueryExecuterFactory factory;

    private SupportedLanguage(QueryExecuterFactory factory) {
        this.factory = factory;
    }

    public QueryExecuterFactory getExecutorFactory() {
        return factory;
    }

    public static String[] names() {
        final SupportedLanguage[] supportedLanguages = SupportedLanguage.values();
        final String[] supportedLanguagesNames = new String[supportedLanguages.length];
        for (int i=0; i<supportedLanguages.length; i++) {
            supportedLanguagesNames[i] = supportedLanguages[i].name().toLowerCase();
        }
        return supportedLanguagesNames;
    }

    public static SupportedLanguage createFrom(String language) {
        for (SupportedLanguage supportedLanguage : SupportedLanguage.values()) {
            if (supportedLanguage.name().equalsIgnoreCase(language)) {
                return supportedLanguage;
            }
        }
        return null;
    }
}
