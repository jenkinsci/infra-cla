# Jenkins project CLA

`icla.txt` and `ccla.txt` contain the CLA paper. In particular,
[icla.txt](https://raw.github.com/jenkinsci/infra-cla/master/icla.txt) and [ccla.txt](https://raw.github.com/jenkinsci/infra-cla/approved/ccla.txt) in the `approved` branch
are the official versions that people should be using.
See [the governance document](https://wiki.jenkins-ci.org/display/JENKINS/Governance+Document) for the background.

# How to file CLA
Have ICLA and/or CCLA printed, signed, scanned back to PDF, then send it to `jenkinsci-cla@googlegroups.com` along with [your account on Jenkins](https://jenkins-ci.org/account).

# How we store signed CLAs
For now, this section is more of a note to the board for how to store this. Eventually I'd like to have people submit this via pull requests.

For each signed individual CLA, there should be one directory named `collected/icla/JENKINSACCOUNT` where `JENKINSACCOUNT` is [the account on Jenkins](https://jenkins-ci.org/account).
This directory should house the CLA encyrpted by GPG in the ASCII armored form.
The public key for this is in `publicKey.asc`:

    curl https://raw.github.com/jenkinsci/infra-cla/approved/publicKey.asc | gpg --import

The command to sign it is:

    gpg --encrypt --sign --armor -r "Jenkins Project CLA" < cla.pdf > cla.pdf.asc

This directory should also have `committer.properties` that capture the key information about this individual.

For each signed corporate CLA, there should be one directory named `collected/ccla/COMPANYNAME`. `COMPANYNAME` could be anything reasonable descriptive and unique. Where an individual is related to a company, have `collected/icla/NAME/ccla` be a symlink to `../../ccla/COMPANYNAME` to establish a relationship.
