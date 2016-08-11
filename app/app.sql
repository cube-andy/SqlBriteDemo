        create table TodoCategory(
             id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
               name TEXT NOT NULL
         );


            create table TodoItem(
            id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
            description TEXT NOT NULL UNIQUE,
            count INTEGER default 0,
            category_id INTEGER NOT NULL ,
            foreign key(category_id) references TodoCategory(id)
            );

            SELECT name , TodoCategory.id , count(TodoItem.id) FROM TodoCategory left OUTER JOIN
            TodoItem  on TodoCategory.id = TodoItem.category_id GROUP BY TodoCategory.id;