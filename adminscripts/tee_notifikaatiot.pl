#!/usr/bin/perl

use DBI;

my $driver = "mysql";
my $database = "mkousa";
my $dsn = "DBI:$driver:database=$database";
my $userid = "mkousa";
my $password = "gaithohquuwa";
my $dbh = DBI->connect($dsn, $userid, $password ) or die $DBI::errstr;

my $paivamaara = `date +\"%Y-%m-%d\"`;

my $sth = $dbh->prepare("SELECT * FROM Sanat");
$sth->execute() or die $DBI::errstr;
while (my @row = $sth->fetchrow_array()) {
   my ($id, $aika, $third ) = @row;
   @aika = split(" ", $aika);
   $aikaKoneenKellosta = $aika[0];
   $aikaKoneenKellosta = trim($aikaKoneenKellosta);
   $paivamaara = trim($paivamaara);

   if($aikaKoneenKellosta eq $paivamaara) {
      $to = 'jukka.juslin@haaga-helia.fi';
      $from = 'inara.shakirova@haaga-helia.fi';
      $subject = 'New words added today!';
      $message = 'This is word app notifier of new words!';

      open(MAIL, "|/usr/sbin/sendmail -t");

      # Email Header
      print MAIL "To: $to\n";
      print MAIL "From: $from\n";
      print MAIL "Subject: $subject\n\n";
     # Email Body
     print MAIL $message;

     close(MAIL);

     print "Email Sent Successfully\n";

      $to = 'inara.shakirova@haaga-helia.fi';
      $from = 'jukka.juslin@haaga-helia.fi';
      $subject = 'New words added today!';
      $message = 'This is word app notifier of new words! http://proto58.haaga-helia.fi/sanat ';

      open(MAIL, "|/usr/sbin/sendmail -t");

      # Email Header
      print MAIL "To: $to\n";
      print MAIL "From: $from\n";
      print MAIL "Subject: $subject\n\n";
     # Email Body
     print MAIL $message;

     close(MAIL);

     print "Email Sent Successfully\n";


     $sth->finish();
     die;
   }
}
