package icu.sunway.naraka.Entity.Action;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(AbstractAction.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class ActionTypeHandler extends BaseTypeHandler<AbstractAction> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, AbstractAction parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getName());
    }

    @Override
    public AbstractAction getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String name = rs.getString(columnName);
        return ActionMap.getActionMap().get(name);
    }

    @Override
    public AbstractAction getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String name = rs.getString(columnIndex);
        return ActionMap.getActionMap().get(name);
    }

    @Override
    public AbstractAction getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String name = cs.getString(columnIndex);
        return ActionMap.getActionMap().get(name);
    }
}
