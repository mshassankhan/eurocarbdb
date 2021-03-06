#  
# Genplot
#

# Linux
#
##WARN = -W -Wreturn-type  -Wformat  -Wcast-align
LFLAGS =  -L/usr/X11R6/lib -lXp -lXext -lXm  -lXt -lX11 -lm
CFLAGS = -I.. -I. 

#
# SGI
#LFLAGS =  -lXm  -lXt -lX11 -lm
#CFLAGS = -I.. -I. 

# Windoze
#LFLAGS = -mwindows -lcomctl32 -lwinspool -lm
#LFLAGS = -mwindows -lcomctl32 -lm
#CFLAGS = -I/usr/gcc-2.95.2/i386-mingw32msvc/include -I.. -I. 

CLINK  = gcc -Dnnn -g -o
CC = gcc -g -c	
#CLINK  = cc -g -o
#CC = cc -g -c	

LINKLIB=../libgp.a 


OBJ_BASE = genplot.o genlist.o genevent.o genclip.o datafile.o btree.o \
      genui.o gendisk.o genrbtree.o mshell.o 
      
OBJ_HPGL=gen_hpgl.o

OBJ_PS=gen_ps.o

OBJ_WMF=gen_wmf.o 

OBJ_DUMM=gen_dumm.o

OBJ_MOTIF=gen_xm.o genmcomm.o genmcons.o genmcurs.o\
          genmmen.o genmpop.o genmscr.o
          
OBJ_WIN = gen_win.o genwscr.o genwcurs.o genwcomm.o genwpop.o\
      genwmenu.o genwcons.o layoutmgr.o genwprint.o

OBJTMP = $(OBJ_BASE) $(OBJ_DUMM) $(OBJ_PS) $(OBJ_HPGL) $(OBJ_WMF) 
OBJ2= $(OBJTMP) $(OBJ_MOTIF)
#OBJ2= $(OBJTMP) $(OBJ_WIN)

SRC_HPGL=hpgl/gen_hpgl.c

SRC_PS=postscript/gen_ps.c

SRC_WMF=winmetafile/gen_wmf.c 

SRC_DUMM=dummy/gen_dumm.c

SRC_MOTIF=motif/gen_xm.c motif/genmcomm.c motif/genmcons.c motif/genmcurs.c\
          motif/genmmen.c motif/genmpop.c motif/genmscr.c

SRC_WIN= mswin/gen_win.c mswin/genwscr.c mswin/genwcurs.c mswin/genwcomm.c\
         mswin/genwpop.c mswin/genwmenu.c mswin/genwcons.c mswin/layoutmgr.c\
         mswin/genwprint.c


SRCTMP = $(OBJ_BASE:.o=.c) $(SRC_DUMM) $(SRC_PS) $(SRC_HPGL) $(SRC_WMF) 
SRC= $(SRCTMP) $(SRC_MOTIF)
#SRC= $(SRCTMP) $(SRC_WIN)

OBJ = $(SRC:.c=.o)

TARGETS=libgp.a gentest


all: .depend_status $(TARGETS)

targets: $(TARGETS)

gentest:  gentest.o libgp.a
	$(CLINK) gentest gentest.o libgp.a $(LFLAGS)
        
gen_dumm.o: dummy/gen_dumm.c
	$(CC) $(CFLAGS) dummy/gen_dumm.c

gen_hpgl.o: hpgl/gen_hpgl.c
	$(CC) $(CFLAGS) hpgl/gen_hpgl.c

gen_ps.o: postscript/gen_ps.c
	$(CC) $(CFLAGS) postscript/gen_ps.c

gen_wmf.o: winmetafile/gen_wmf.c 
	$(CC) $(CFLAGS) winmetafile/gen_wmf.c

gen_xm.o: motif/gen_xm.c
	$(CC) $(CFLAGS) motif/gen_xm.c

genmcomm.o: motif/genmcomm.c 
	$(CC) $(CFLAGS) motif/genmcomm.c

genmcons.o: motif/genmcons.c 
	$(CC) $(CFLAGS) motif/genmcons.c
 
genmcurs.o: motif/genmcurs.c
	$(CC) $(CFLAGS) motif/genmcurs.c

genmmen.o: motif/genmmen.c 
	$(CC) $(CFLAGS) motif/genmmen.c

genmpop.o: motif/genmpop.c 
	$(CC) $(CFLAGS) motif/genmpop.c

genmscr.o: motif/genmscr.c
	$(CC) $(CFLAGS) motif/genmscr.c


gen_win.o: mswin/gen_win.c
	$(CC) $(CFLAGS) $<
        
genwscr.o: mswin/genwscr.c
	$(CC) $(CFLAGS) $<
        
genwcurs.o: mswin/genwcurs.c
	$(CC) $(CFLAGS) $<
        
genwcomm.o: mswin/genwcomm.c 
	$(CC) $(CFLAGS) $<
        
genwpop.o: mswin/genwpop.c
	$(CC) $(CFLAGS) $<      

genwmenu.o: mswin/genwmenu.c 
	$(CC) $(CFLAGS) $<
        
genwcons.o: mswin/genwcons.c 
	$(CC) $(CFLAGS) $<
        
layoutmgr.o: mswin/layoutmgr.c 
	$(CC) $(CFLAGS) $<
        
genwprint.o: mswin/genwprint.c
	$(CC) $(CFLAGS) $<


.c.o: 
	$(CC) $(CFLAGS) $*.c

#	mv -u ${@F} ${*D}


libgp.a:: $(OBJ2)
	ar r $@ $(OBJ2)

#libgp.a:: $(OBJ)#
#	ar r $@ ${?F}

#libgp.a:: $(OBJ)
#	ar r $@ ${OBJ}

     

#
clean:
	-rm -f *.o *.a core .depend .depend_status

.depend_status:
	make depend
	make targets

depend:
	@echo Determining dependencies
	@echo "#Do not delete" > .depend_status
	$(CC) $(CFLAGS) -M gentest.c $(SRC) > .depend
	
dep: depend

sinclude .depend

#
# Dump the whole thing in a tar file
#

BASEDIRNAME=genplot
TOP = .
CURRENT_DIR = .
HEADERS = genplot.h g_inter1.h g_inter2.h g_inter.h btree.h colors.h\
          motif/genmotif.h mswin/*.h genrbtree.h mshell.h hand.xbm handmask.xbm\
          hand32.xbm handm32.xbm color_lookup.h
TEXT2 = Makefile dummy/Makefile postscript/Makefile hpgl/Makefile motif/Makefile\
       winmetafile/Makefile Imakefile 
#TEXT = makefile

MISC = $(HEADERS) pixmaps/disk.xpm\
       pixmaps/disk_gray.xpm pixmaps/disk_sel.xpm pixmaps/hand.xpm\
       pixmaps/hand1.xpm pixmaps/handmask.xpm pixmaps/toolbox.xpm\
       pixmaps/toolbox_gray.xpm pixmaps/zip.xpm\
       pixmaps/zip_gray.xpm doc/*.html doc/*.gif

SRCS = gentest.c $(OBJ_BASE:.o=.c) $(SRC_DUMM) $(SRC_PS) $(SRC_HPGL) $(SRC_WMF)\
           $(SRC_MOTIF) $(SRC_WIN)


makelist::
	-rm filelist
	@touch filelist

dosmakelist::
	-rm filelist
	@touch filelist

makelist::
	sh -c 'for i in '"$(TEXT) $(SRCS) $(HDRS) $(MISC)"' ;\
        do	echo $(CURRENT_DIR)/$$i >> $(TOP)/filelist ; done '

dosmakelist::
	sh -c 'for i in $(TEXT) $(SRCS) $(HDRS) $(MISC) ;\
        do	echo $$i >> filelist ; done '

#kit: makelist
#	sh -c 'sum="`cat filelist`" ; makekit -oMANIFEST MANIFEST $$sum'

tar: makelist
	sh -c 'cd .. ;\
        tar cf - `sed -e "s:^./::" -e "s:^:genplot/:" genplot/filelist`\
        | gzip > genplot.tgz'

dostar: dosmakelist
	sh -c 'tar cf - `sed -e "s:^./::" filelist`\
        | gzip > genplot.tgz'

#
# DO NOT DELETE



