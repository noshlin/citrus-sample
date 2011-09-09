package com.alibaba.sample.petstore.common.auth.impl;

import static com.alibaba.citrus.util.Assert.*;
import static com.alibaba.citrus.util.ObjectUtil.*;

import com.alibaba.citrus.util.internal.ToStringBuilder;
import com.alibaba.citrus.util.internal.ToStringBuilder.MapBuilder;

/**
 * 代表一组patterns和grants授权的组合。
 * 
 * @author Michael Zhou
 */
public class AuthMatch {
    private final static AuthGrant[] NO_GRANTS = new AuthGrant[0];
    private final AuthPattern pattern;
    private final AuthGrant[] grants;

    public AuthMatch(AuthPattern pattern, AuthGrant[] grants) {
        this.pattern = assertNotNull(pattern, "pattern");
        this.grants = defaultIfNull(grants, NO_GRANTS);
    }

    public AuthPattern getPattern() {
        return pattern;
    }

    public AuthGrant[] getGrants() {
        return grants;
    }

    @Override
    public String toString() {
        MapBuilder mb = new MapBuilder();

        mb.append("pattern", pattern);
        mb.append("grants", grants);

        return new ToStringBuilder().append("Match").append(mb).toString();
    }
}
