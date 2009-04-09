/* 
 *
 * SchemaCrawler
 * http://sourceforge.net/projects/schemacrawler
 * Copyright (c) 2000-2009, Sualeh Fatehi.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 */

package schemacrawler.crawl;


import schemacrawler.schema.DatabaseObject;
import schemacrawler.schema.Index;
import schemacrawler.schema.IndexColumn;
import schemacrawler.schema.PrimaryKey;

/**
 * Represents a primary key in a table.
 * 
 * @author Sualeh Fatehi
 */
class MutablePrimaryKey
  extends MutableIndex
  implements PrimaryKey
{

  private static final long serialVersionUID = -7169206178562782087L;

  /**
   * Copies information from an index.
   * 
   * @param index
   *        Index
   */
  MutablePrimaryKey(final Index index)
  {
    super(index.getParent(), index.getName());
    setCardinality(index.getCardinality());
    setPages(index.getPages());
    setRemarks(index.getRemarks());
    setType(index.getType());
    setUnique(index.isUnique());
    // Copy columns
    for (final IndexColumn column: index.getColumns())
    {
      addColumn(column.getOrdinalPosition(), (MutableIndexColumn) column);
    }
  }

  MutablePrimaryKey(final String name, final DatabaseObject parent)
  {
    super(parent, name);
  }

  /**
   * {@inheritDoc}
   * 
   * @see Index#isUnique()
   */
  @Override
  public final boolean isUnique()
  {
    return true;
  }

}
