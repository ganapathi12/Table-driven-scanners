# Table-driven-scanners

The idea of a table-driven scanner is simple -- we have a table
that says what to do if we are in one particular state and see a
particular input character. This is basically the transition
table for the DFA. Building the table can be a pain, but then
your scanner is a simple loop. The table size can be
significant (my Scanner for BPL has 35 tokens, so the DFA
needs at least 35 states; there are at least 128 possible input
characters, so you need a table with about 5,000 entries for
BPL) but even for a full implementation of C or Java it
wouldn't be too big to reside in memory.


<p>Table driven scanners in Java, exporting dfa's from csv files</p>
<p>->table driven scanner</p>
<p>->direct coded scanner</p>
<p>->maximal munch scanner</p>
<p>->dfa class which gathers data from csv files to respective data structures</p>
<p>->test class which containes the main driver code</p>
