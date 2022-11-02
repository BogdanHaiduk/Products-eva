package com.products.eva.util;

import java.util.Map;

public class TestUtil {
    public static String getURL(String host, String path, Map<String, String> requestParam) {
        StringBuffer stringBuffer = new StringBuffer(host);

        if (path != null) {
            stringBuffer.append(path);

            if (requestParam != null && !requestParam.isEmpty()) {
                stringBuffer.append("?");
                requestParam.forEach((key, value) -> {
                    stringBuffer.append(key);
                    stringBuffer.append("=");
                    stringBuffer.append(value);
                });
            }

            return stringBuffer.toString();
        }

        return stringBuffer.toString();
    }
}
