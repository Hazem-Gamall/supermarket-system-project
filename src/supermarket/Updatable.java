/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author hazem
 */
public interface Updatable {
        void update(Connection con) throws SQLException;
}
