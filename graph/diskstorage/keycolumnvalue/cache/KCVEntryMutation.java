/*
 * Copyright (C) 2020 Grakn Labs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package grakn.core.graph.diskstorage.keycolumnvalue.cache;

import com.google.common.base.Function;
import grakn.core.graph.diskstorage.Entry;
import grakn.core.graph.diskstorage.Mutation;
import grakn.core.graph.diskstorage.StaticBuffer;

import javax.annotation.Nullable;
import java.util.List;


public class KCVEntryMutation extends Mutation<Entry, Entry> {

    public KCVEntryMutation(List<Entry> additions, List<Entry> deletions) {
        super(additions, deletions);
    }

    public static final Function<Entry, StaticBuffer> ENTRY2COLUMN_FCT = new Function<Entry, StaticBuffer>() {
        @Nullable
        @Override
        public StaticBuffer apply(Entry entry) {
            return entry.getColumn();
        }
    };

    @Override
    public void consolidate() {
        super.consolidate(ENTRY2COLUMN_FCT,ENTRY2COLUMN_FCT);
    }

    @Override
    public boolean isConsolidated() {
        return super.isConsolidated(ENTRY2COLUMN_FCT,ENTRY2COLUMN_FCT);
    }

}